package document.receipt.impl

import document.receipt.IPaymentDetails
import utils.DateTimeUtil
import java.util.*

class PaymentDetailsImpl : IPaymentDetails {

    private var mPaymentSystemName: String? = null
    private var mPaymentProvider: String? = null
    private var mTransactionId: String? = null
    private var mTransactionDateTime: String? = null
    private var mReceiptNumber: String? = null
    private var mDeviceId: String? = null
    private var mPersonalAccountNumber: String? = null
    private var mAuthCode: String? = null

    override fun getPaymentSystemName(): String? {
        return mPaymentSystemName
    }

    override fun setPaymentSystemName(paymentSystemName: String?) {
        mPaymentSystemName = paymentSystemName
    }

    override fun getPaymentProvider(): String? {
        return mPaymentProvider
    }

    override fun setPaymentProvider(paymentProvider: String?) {
        mPaymentProvider = paymentProvider
    }

    override fun getTransactionId(): String? {
        return mTransactionId
    }

    override fun setTransactionId(transactionId: String?) {
        mTransactionId = transactionId
    }

    override fun getTransactionDateTime(): String? {
        return mTransactionDateTime
    }

    override fun setTransactionDateTime(transactionDateTime: String?) {
        mTransactionDateTime = transactionDateTime
    }

    override fun getFormattedTransactionDateTime(): String? {
        getTransactionDateTime()?.let { println(DateTimeUtil.dateFromString(it)) }
        return null;
    }

    override fun getReceiptNumber(): String? {
        return mReceiptNumber
    }

    override fun setReceiptNumber(receiptNumber: String?) {
        mReceiptNumber = receiptNumber
    }

    override fun getDeviceId(): String? {
        return mDeviceId
    }

    override fun setDeviceId(deviceId: String?) {
        mDeviceId = deviceId
    }

    override fun getPersonalAccountNumber(): String? {
        return mPersonalAccountNumber
    }

    override fun setPersonalAccountNumber(personalAccountNumber: String?) {
        mPersonalAccountNumber = personalAccountNumber
    }

    override fun getAuthCode(): String? {
        return mAuthCode
    }

    override fun setAuthCode(authCode: String?) {
        mAuthCode = authCode
    }
}