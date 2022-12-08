package cd.wapupdotdev.util

object DeepLink {
  const val baseUri = "https://orders.be-served.com"
  private const val storeEndPoint = "groups/{uidGroup}/stores/{uidStore}"
  private const val orderEndPoint = "orders/{uidOrder}"
  private const val productEndPoint = "groups/{uidGroup}/stores/{uidStore}/products/{uidProduct}"

  const val storeUri = "$baseUri/$storeEndPoint"
  const val orderUri = "$baseUri/$orderEndPoint"
  const val productUri = "$baseUri/$productEndPoint"

  fun createStoreLink(uidGroup: String, uidStore: String): String {
    return storeUri
      .replace("{uidGroup}", uidGroup)
      .replace("{uidStore}", uidStore)
  }

  fun createOrderLink(uidOrder: String): String {
    return storeUri.replace("{uidOrder}", uidOrder)
  }

  fun createProductLink(uidGroup: String, uidStore: String, uidProduct: String): String {
    return productUri
      .replace("{uidGroup}", uidGroup)
      .replace("{uidStore}", uidStore)
      .replace("{uidProduct}", uidProduct)
  }
}