package th.ac.buu.se.myfinaltest

class ProductModel {
    var name: String? = null
    var price: String? = null
    var status_in_cart = false

    constructor()

    constructor(name: String, price: String, status: Boolean = false) {
        this.name = name
        this.price = price
        this.status_in_cart = status
    }
}