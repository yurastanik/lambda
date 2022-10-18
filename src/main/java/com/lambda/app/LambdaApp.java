package com.lambda.app;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import document.common.DocumentType;
import document.common.IDocument;
import org.json.JSONObject;
import view.html.impl.HtmlSerializer;
import view.xml.impl.XmlDeserializer;

public class LambdaApp implements RequestHandler<Object, String> {


    public String handleRequest(Object data, Context context) {
        String json = data != null ? data.toString() : "{}";
        JSONObject jsonObj = new JSONObject(json.replaceAll("=", ":"));
        if (!jsonObj.isEmpty() && jsonObj.has("data")) {
            String xml = jsonObj.getString("data");
            System.out.println(xml);
            try {
                IDocument document = new XmlDeserializer().deserialize(xml.getBytes());
                if (document.getDocumentType() == DocumentType.Sale
                        || document.getDocumentType() == DocumentType.Return
                        || document.getDocumentType() == DocumentType.ZReport) {
                    byte[] bytes = new HtmlSerializer().serialize(document, null);
                    System.out.println("\n");
                    System.out.println(new String(bytes));
                    return new String(bytes);
                }
            } catch (IllegalArgumentException ignored) {
                return null;
            }
        }
        return null;
    }
}
