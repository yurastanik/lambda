<#assign CompanyName="${document.getDocumentHeader().getCompanyName()}">

<!DOCTYPE html>
<html lang="ua">

<head>
  <meta charset="UTF-8">
  <style>
    table {
      margin-left: auto;
      margin-right: auto;
      border: 2px solid #ccc;
      /*font-family: monospace, monospace;*/
      font-family: sans-serif;
      font-size: 9pt;
      padding: 4mm;
      width: 72mm;
    }

    .vertical-indent {
      height: 5mm;
    }

    td.left {
      text-align: left;
    }

    td.right {
      text-align: right;
    }

    td.center {
      text-align: center;
    }
  </style>
</head>

<body>
  <div>
    <table>
        <#setting locale="en_US">
        <#setting number_format="0.00">
        <#include 'check-header.ftl'>
		<#if document.getProducts()?has_content>
        <#list document.getProducts() as product>
            <#if product.getAmount()?has_content>
            <tr>
                <td colspan="5">${product.getAmount()} x ${product.getPrice()}</td>
            </tr>
            </#if>
            <#if product.getNationalCode()?has_content>
            <tr>
                <td colspan="5">УКТ ЗЕД: ${product.getNationalCode()}</td>
            </tr>
            </#if>
            <#if product.getCode()?has_content>
            <tr>
                <td colspan="5">АРТ.№ ${product.getCode()}</td>
            </tr>
            </#if>
            <#if product.getExciseLabels()?has_content>
            <#list product.getExciseLabels() as excise>
                <tr>
                    <td colspan="5">Акцизна марка: ${excise.getLabel()}</td>
                </tr>
            </#list>
            </#if>
            <#if product.getName()?has_content>
            <tr>
                <td colspan="3">${product.getName()}:</td>
                <#if product.getCost()?has_content>
                    <#if product.getTaxRateLetter()?has_content>
                    <td colspan="2" style="text-align:right">${product.getCost()} ${product.getTaxRateLetter()}</td>
                    <#else>
                    <td colspan="2" style="text-align:right">${product.getCost()}}</td>
                    </#if>
                </#if>
            </tr>
            </#if>
            <#if product.getDiscountSum()?has_content>
            <tr>
                <td colspan="5">Дисконт: ${product.getDiscountSum()}</td>
            </tr>
            </#if>
            <#if product.getComment()?has_content>
            <tr>
                <td colspan="5">${product.getComment()}</td>
            </tr>
            </#if>
            <tr>
                <td colspan="5">&nbsp;</td>
            </tr>
        </#list>
        </#if>
		<#if document.getPayForms()?has_content>
        <#list document.getPayForms() as payForm>
            <#if payForm.getPaymentDetails()?has_content>
                <tr>
                    <td colspan="5" style="text-align:center">--- &nbsp;Платіжна система&nbsp; ---</td>
                </tr>
                <#if payForm.getPaymentDetails().getPaymentProvider()?has_content>
                <tr>
                    <td colspan="5">Банк: ${payForm.getPaymentDetails().getPaymentProvider()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getDeviceId()?has_content>
                <tr>
                    <td colspan="5">Термінал: ${payForm.getPaymentDetails().getDeviceId()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getPersonalAccountNumber()?has_content>
                <tr>
                    <td colspan="5">ЕПЗ: ${payForm.getPaymentDetails().getPersonalAccountNumber()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getPaymentSystemName()?has_content>
                <tr>
                    <td colspan="5">ПЛАТІЖНА СИСТЕМА: ${payForm.getPaymentDetails().getPaymentSystemName()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getAuthCode()?has_content>
                <tr>
                    <td colspan="5">КОД АВТ.: ${payForm.getPaymentDetails().getAuthCode()}</td>
                </tr>
                </#if>
                <tr>
                    <td colspan="5">КАСИР Підпис не передбачено</td>
                </tr>
                <tr>
                    <td colspan="5">ДЕРЖАТЕЛЬ ЕПЗ Підпис не передбачено</td>
                </tr>
                <#if payForm.getPaymentDetails().getTransactionId()?has_content>
                <tr>
                    <td colspan="5">RRN: ${payForm.getPaymentDetails().getTransactionId()}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getTransactionDateTime()?has_content>
                <tr>
                    <td colspan="5">Час транзакції ${payForm.getPaymentDetails().getTransactionDateTime()?number?number_to_datetime}</td>
                </tr>
                </#if>
                <#if payForm.getPaymentDetails().getReceiptNumber()?has_content>
                <tr>
                    <td colspan="5">Номер Чеку: ${payForm.getPaymentDetails().getReceiptNumber()}</td>
                </tr>
                </#if>
                <tr>
                    <td colspan="5" style="text-align:center">&nbsp;</td>
                </tr>
            </#if>
        </#list>
        </#if>
    </table>
  </div>
</body>

</html>