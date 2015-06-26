package ru.server.xml;

import java.util.HashMap;

/**
 *
 * @author White2Demon
 */
public class Message {

    private HashMap<String, String> content;

    public Message() {
        content = new HashMap<String, String>();
    }

    public Message(HashMap<String, String> content) {
        this.content = content;
    }

    public String get(String tagName) {
        String result = content.get(tagName);
        if(result != null) {
            result = result.trim();
        }
        return result;
    }

    public void set(String tagName, String tagValue) {
        content.put(tagName, tagValue);
    }
}
