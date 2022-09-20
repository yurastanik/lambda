package document.receipt


import document.common.IDocument
import document.common.IDocumentTaxRate
import document.receipt.IReceiptPayForm
import document.receipt.IReceiptProduct
import document.receipt.IReceiptTotal

interface IReceiptDocument : IDocument {

    fun setTotal(total: IReceiptTotal?)
    fun getTotal(): IReceiptTotal?

    fun setPayForms(payForms: List<IReceiptPayForm>?)
    fun getPayForms(): List<IReceiptPayForm>?

    fun setTaxRates(taxRates: List<IDocumentTaxRate>?)
    fun getTaxRates(): List<IDocumentTaxRate>?

    fun setProducts(products: List<IReceiptProduct>?)
    fun getProducts(): List<IReceiptProduct>?
}