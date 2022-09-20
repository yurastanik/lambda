import document.receipt.IReceiptDocument;
import document.report.IReportDocument;
import org.junit.Test;
import utils.ResourcesUtil;
import view.html.impl.HtmlSerializer;
import view.xml.impl.receipt.XmlReceiptDocument;
import view.xml.impl.report.XmlReportDocument;
import view.xml.impl.utils.XmlMapperUtil;

public class TestClass {


    private final HtmlSerializer htmlSerializer = new HtmlSerializer();

    @Test
    public void serializeCheckDocument() {
        IReceiptDocument reportDocument = new XmlMapperUtil().fromXML(XmlReceiptDocument.class,
                new ResourcesUtil().getResource("sale.xml"));
        byte[] bytes = htmlSerializer.serialize(reportDocument, null);
        System.out.println(new String(bytes));
    }

    @Test
    public void serializeReportDocument() {
        IReportDocument reportDocument = new XmlMapperUtil().fromXML(XmlReportDocument.class,
                new ResourcesUtil().getResource("zReport.xml"));
        byte[] bytes = htmlSerializer.serialize(reportDocument, null);
        System.out.println(new String(bytes));
    }
}
