import document.receipt.IReceiptDocument;
import document.report.IReportDocument;
import org.json.JSONObject;
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

    @Test
    public void wrapDocument() {
        String data = "{" +
                "data: <?xml version=\\\"1.0\\\" encoding=\\\"windows-1251\\\"?><CHECK xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\" xsi:noNamespaceSchemaLocation=\\\"file:///C:/Users/yuras/workProjects/lambda/src/main/resources/check01.xsd\\\"><CHECKHEAD>\t\t<DOCTYPE>0</DOCTYPE>\t\t<DOCSUBTYPE>0</DOCSUBTYPE>\t\t<UID>cc9c2408-b021-4afc-8272-5c92ce4677c9</UID>\t\t<TIN>34554363</TIN>\t\t<IPN>123456789020</IPN>\t\t<ORGNM>Тестовий платник 4</ORGNM>\t\t<POINTNM>Магазин Іван-Тест</POINTNM>\t\t<POINTADDR>УКРАЇНА, СУМСЬКА ОБЛ., М. СУМИ, вул. Соборна 1</POINTADDR>\t\t<ORDERDATE>19092021</ORDERDATE>\t\t<ORDERTIME>172924</ORDERTIME>\t\t<ORDERNUM>3351</ORDERNUM>\t\t<CASHDESKNUM>51</CASHDESKNUM>\t\t<CASHREGISTERNUM>4000066888</CASHREGISTERNUM>\t\t<CASHIER>Для РРО № 4000066888</CASHIER>\t\t<COMMENT>ПРРО Check-Online</COMMENT>\t\t<VER>1</VER>\t\t<ORDERTAXNUM>43137674</ORDERTAXNUM>\t</CHECKHEAD>\t<CHECKTOTAL>\t\t<SUM>6584.43</SUM>\t\t<RNDSUM>0.02</RNDSUM>\t\t<NORNDSUM>6584.45</NORNDSUM>\t\t<DISCOUNTSUM>25.00</DISCOUNTSUM>\t</CHECKTOTAL>\t<CHECKPAY>\t\t<ROW ROWNUM=\\\"1\\\">\t\t\t<PAYFORMCD>0</PAYFORMCD>\t\t\t<PAYFORMNM>Готівка</PAYFORMNM>\t\t\t<SUM>6084.40</SUM>\t\t\t<PROVIDED>6100.00</PROVIDED>\t\t\t<REMAINS>15.60</REMAINS>\t\t</ROW>\t\t<ROW ROWNUM=\\\"2\\\">\t\t\t<PAYFORMCD>1</PAYFORMCD>\t\t\t<PAYFORMNM>Банківська картка</PAYFORMNM>\t\t\t<SUM>400.02</SUM>\t\t\t<PAYSYS>\t\t\t\t<ROW ROWNUM=\\\"1\\\">\t\t\t\t\t<NAME>VISA</NAME>\t\t\t\t\t<ACQUIRENM>ОЩАДБАНК</ACQUIRENM>\t\t\t\t\t<ACQUIRETRANSID>77777777777</ACQUIRETRANSID>\t\t\t\t\t<POSTRANSDATE>01032021234653</POSTRANSDATE>\t\t\t\t\t<POSTRANSNUM>9980</POSTRANSNUM>\t\t\t\t\t<DEVICEID>S1K10078</DEVICEID>\t\t\t\t\t<EPZDETAILS>XXXX XXXX XXXX 1234</EPZDETAILS>\t\t\t\t\t<AUTHCD>842415</AUTHCD>\t\t\t\t</ROW>\t\t\t</PAYSYS>\t\t</ROW>\t\t<ROW ROWNUM=\\\"3\\\">\t\t\t<PAYFORMCD>2</PAYFORMCD>\t\t\t<PAYFORMNM>Попередня оплата</PAYFORMNM>\t\t\t<SUM>100.01</SUM>\t\t</ROW>\t</CHECKPAY>\t<CHECKTAX>\t\t<ROW ROWNUM=\\\"1\\\">\t\t\t<TYPE>1</TYPE>\t\t\t<NAME>Акциз</NAME>\t\t\t<LETTER>М</LETTER>\t\t\t<PRC>5.00</PRC>\t\t\t<SIGN>false</SIGN>\t\t\t<TURNOVER>259.90</TURNOVER>\t\t\t<SOURCESUM>244.90</SOURCESUM>\t\t\t<SUM>11.66</SUM>\t\t</ROW>\t\t<ROW ROWNUM=\\\"2\\\">\t\t\t<TYPE>0</TYPE>\t\t\t<NAME>ПДВ</NAME>\t\t\t<LETTER>A</LETTER>\t\t\t<PRC>20.00</PRC>\t\t\t<SIGN>false</SIGN>\t\t\t<TURNOVER>575.05</TURNOVER>\t\t\t<SOURCESUM>538.39</SOURCESUM>\t\t\t<SUM>89.73</SUM>\t\t</ROW>\t\t<ROW ROWNUM=\\\"3\\\">\t\t\t<TYPE>0</TYPE>\t\t\t<NAME>ПДВ</NAME>\t\t\t<LETTER>Б</LETTER>\t\t\t<PRC>7.00</PRC>\t\t\t<SIGN>false</SIGN>\t\t\t<TURNOVER>3405.00</TURNOVER>\t\t\t<SOURCESUM>3405.00</SOURCESUM>\t\t\t<SUM>222.76</SUM>\t\t</ROW>\t\t<ROW ROWNUM=\\\"4\\\">\t\t\t<TYPE>0</TYPE>\t\t\t<NAME>ПДВ</NAME>\t\t\t<LETTER>В</LETTER>\t\t\t<PRC>0.00</PRC>\t\t\t<SIGN>false</SIGN>\t\t\t<TURNOVER>111.80</TURNOVER>\t\t\t<SOURCESUM>111.80</SOURCESUM>\t\t\t<SUM>0.00</SUM>\t\t</ROW>\t\t<ROW ROWNUM=\\\"5\\\">\t\t\t<TYPE>0</TYPE>\t\t\t<NAME>ПДВ</NAME>\t\t\t<LETTER>Д</LETTER>\t\t\t<PRC>0.00</PRC>\t\t\t<SIGN>false</SIGN>\t\t\t<TURNOVER>2517.60</TURNOVER>\t\t\t<SOURCESUM>2517.60</SOURCESUM>\t\t\t<SUM>0.00</SUM>\t\t</ROW>\t</CHECKTAX>\t<CHECKBODY>\t\t<ROW ROWNUM=\\\"1\\\">\t\t\t<CODE>8765</CODE>\t\t\t<UKTZED>1234567</UKTZED>\t\t\t<NAME>Пиво коробка (3 шт)</NAME>\t\t\t<DESCRIPTION>Экстра</DESCRIPTION>\t\t\t<UNITCD>2009</UNITCD>\t\t\t<UNITNM>л</UNITNM>\t\t\t<AMOUNT>1.000</AMOUNT>\t\t\t<PRICE>259.90</PRICE>\t\t\t<LETTERS>AМ</LETTERS>\t\t\t<COST>259.90</COST>\t\t\t<DISCOUNTSUM>15.00</DISCOUNTSUM>\t\t\t<COMMENT>Этот товар Вам достался со скидкой 15.00!</COMMENT>\t\t\t<EXCISELABELS>\t\t\t\t<ROW ROWNUM=\\\"1\\\">\t\t\t\t\t<EXCISELABEL>333333 21/02/2021</EXCISELABEL>\t\t\t\t</ROW>\t\t\t\t<ROW ROWNUM=\\\"2\\\">\t\t\t\t\t<EXCISELABEL>444444 25/03/2021</EXCISELABEL>\t\t\t\t</ROW>\t\t\t\t<ROW ROWNUM=\\\"3\\\">\t\t\t\t\t<EXCISELABEL>555555 23/04/2021</EXCISELABEL>\t\t\t\t</ROW>\t\t\t</EXCISELABELS>\t\t</ROW>\t\t<ROW ROWNUM=\\\"2\\\">\t\t\t<CODE>42342</CODE>\t\t\t<NAME>Коньки</NAME>\t\t\t<DESCRIPTION>Элит</DESCRIPTION>\t\t\t<UNITCD>2009</UNITCD>\t\t\t<UNITNM>шт</UNITNM>\t\t\t<AMOUNT>1.000</AMOUNT>\t\t\t<PRICE>315.15</PRICE>\t\t\t<LETTERS>A</LETTERS>\t\t\t<COST>315.15</COST>\t\t\t<DISCOUNTSUM>10.00</DISCOUNTSUM>\t\t\t<COMMENT>Этот товар выбирают 98% наших покупателей!</COMMENT>\t\t</ROW>\t\t<ROW ROWNUM=\\\"3\\\">\t\t\t<CODE>12332</CODE>\t\t\t<NAME>Шлем</NAME>\t\t\t<DESCRIPTION>Стандарт</DESCRIPTION>\t\t\t<UNITCD>2009</UNITCD>\t\t\t<UNITNM>шт</UNITNM>\t\t\t<AMOUNT>10.000</AMOUNT>\t\t\t<PRICE>340.50</PRICE>\t\t\t<LETTERS>Б</LETTERS>\t\t\t<COST>3405.00</COST>\t\t\t<COMMENT>На складе осталось 5шт этого товара!</COMMENT>\t\t</ROW>\t\t<ROW ROWNUM=\\\"4\\\">\t\t\t<CODE>42342</CODE>\t\t\t<NAME>Шайба</NAME>\t\t\t<DESCRIPTION>Канада</DESCRIPTION>\t\t\t<UNITCD>2009</UNITCD>\t\t\t<UNITNM>шт</UNITNM>\t\t\t<AMOUNT>2.000</AMOUNT>\t\t\t<PRICE>55.90</PRICE>\t\t\t<LETTERS>В</LETTERS>\t\t\t<COST>111.80</COST>\t\t\t<COMMENT>Вам начислен Бонус за покупку этого товара 20!</COMMENT>\t\t</ROW>\t\t<ROW ROWNUM=\\\"5\\\">\t\t\t<CODE>987</CODE>\t\t\t<NAME>Лёд</NAME>\t\t\t<DESCRIPTION>ХимПром</DESCRIPTION>\t\t\t<UNITCD>2009</UNITCD>\t\t\t<UNITNM>кг</UNITNM>\t\t\t<AMOUNT>8.000</AMOUNT>\t\t\t<PRICE>314.70</PRICE>\t\t\t<LETTERS>Д</LETTERS>\t\t\t<COST>2517.60</COST>\t\t</ROW>\t</CHECKBODY></CHECK>" +
                "}";
        System.out.println(data);
        JSONObject json = new JSONObject(data);
        System.out.println(json);
    }
}
