/**
 * 
 */
package com.shtick.utils.data.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.shtick.util.tokenizers.TokenIssue;
import com.shtick.util.tokenizers.TokenTree;
import com.shtick.util.tokenizers.json.ArrayToken;
import com.shtick.util.tokenizers.json.JSONToken;
import com.shtick.util.tokenizers.json.JSONTokenizer;
import com.shtick.util.tokenizers.json.KeywordToken;
import com.shtick.util.tokenizers.json.NumberToken;
import com.shtick.util.tokenizers.json.ObjectPropertyToken;
import com.shtick.util.tokenizers.json.ObjectToken;
import com.shtick.util.tokenizers.json.StringToken;

/**
 * @author sean.cox
 *
 */
public class JSONDecoder {
	private static JSONTokenizer jsonTokenizer = new JSONTokenizer();
	
	/**
	 * 
	 * @param in
	 * @param numberDecoder Provides customized behavior for converting a JSON number to an Object. (Optional)
	 * @return A Map&lt;String,Object>, Double (or whatever the provided numberDecoder identifies to be returned), a List&lt;Object>, String, Boolean, or null.
	 *         null will be returned either for the null literal, or for an empty in.
	 * @throws IllegalArgumentException
	 */
	public static Object decode(InputStream in, JSONNumberDecoder numberDecoder) throws IllegalArgumentException{
		TokenTree<JSONToken> tokenTree;
		try{
			tokenTree = jsonTokenizer.tokenize(in);
			for(TokenIssue issue:tokenTree.getAllIssues()) {
				System.err.println(issue);
				System.err.println("("+issue.getLine()+":"+issue.getCharacter()+") "+issue.getID()+": "+issue.getDescription());
			}
		}
		catch(IOException t){
			throw new RuntimeException(t);
		}
		return decode(tokenTree, numberDecoder);
	}
	
	/**
	 * 
	 * @param json
	 * @param numberDecoder Provides customized behavior for converting a JSON number to an Object. (Optional)
	 * @return A Map&lt;String,Object>, Double (or whatever the provided numberDecoder identifies to be returned), a List&lt;Object>, String, Boolean, or null.
	 *         null will be returned either for the null literal, or for an empty json value.
	 * @throws IllegalArgumentException
	 */
	public static Object decode(String json, JSONNumberDecoder numberDecoder) throws IllegalArgumentException{
		TokenTree<JSONToken> tokenTree;
		json=json.trim();
		if(json.length()==0)
			return null;
		try{
			tokenTree = jsonTokenizer.tokenize(new StringReader(json));
		}
		catch(IOException t){
			throw new RuntimeException(t);
		}
		return decode(tokenTree, numberDecoder);
	}

	private static Object decode(TokenTree<JSONToken> tokenTree, JSONNumberDecoder numberDecoder) throws IllegalArgumentException{
		Iterator<JSONToken> iter = tokenTree.iterator();
		if(!iter.hasNext())
			return null;
		JSONToken token = iter.next();
		if(iter.hasNext())
			throw new IllegalArgumentException("Extra data was found in the input.");
		Collection<TokenIssue> allIssues = tokenTree.getAllIssues();
		if(tokenTree.getAllIssues().size()>0)
			throw new IllegalArgumentException("Syntax errors ("+allIssues.size()+") in JSON. eg. "+allIssues.iterator().next().getDescription());
		
		return decodeUncertain(token, numberDecoder);
	}

	/**
	 * 
	 * @param value
	 * @param numberDecoder Provides customized behavior for converting a JSON number to an Object. (Optional)
	 * @return A Map&lt;String,Object>, a List&lt;Object>, a String, a null, a Boolean, or whatever is returned by the numberDecoder (by default, this is a Double).
	 * @throws IllegalArgumentException
	 */
	private static Object decodeUncertain(JSONToken value, JSONNumberDecoder numberDecoder) throws IllegalArgumentException{
		if(value instanceof NumberToken) {
			if(numberDecoder!=null)
				return numberDecoder.decodeNumber((NumberToken)value);
			return Double.valueOf(((NumberToken)value).toString());
		}
		if(value instanceof ObjectToken)
			return decodeObject((ObjectToken)value, numberDecoder);
		if(value instanceof ArrayToken)
			return decodeArray((ArrayToken)value, numberDecoder);
		if(value instanceof StringToken)
			return ((StringToken)value).getRepresentedString();
		if(value instanceof KeywordToken) {
			switch(((KeywordToken)value).getText()) {
			case KeywordToken.KEYWORD_FALSE:
				return new Boolean(false);
			case KeywordToken.KEYWORD_TRUE:
				return new Boolean(true);
			case KeywordToken.KEYWORD_NULL:
				return null;
			}
		}
		throw new IllegalArgumentException("Unrecognized token: "+value.getClass().getCanonicalName());
	}

	private static Map<String,Object> decodeObject(ObjectToken objectToken, JSONNumberDecoder numberDecoder) throws IllegalArgumentException{
		List<ObjectPropertyToken> properties = objectToken.getObjectPropertyTokens();
		HashMap<String,Object> retval = new HashMap<>(properties.size());
		String label;
		JSONToken value;
		for(ObjectPropertyToken property:properties){
			label=property.getLabel().getRepresentedString();
			value=property.getValue();
			retval.put(label,decodeUncertain(value, numberDecoder));
		}
		return retval;
	}

	private static List<Object> decodeArray(ArrayToken arrayToken, JSONNumberDecoder numberDecoder) throws IllegalArgumentException{
		List<JSONToken> children = arrayToken.getValueTokens();
		ArrayList<Object> retval = new ArrayList<>(children.size());
		for(JSONToken child:children)
			retval.add(decodeUncertain(child, numberDecoder));
		return retval;
	}
}
