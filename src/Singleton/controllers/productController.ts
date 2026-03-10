import ConnectDB from "../db/connectDB";

class ProductController {
  static async getProducts() {
    const db = ConnectDB.getDB();

    const products = await db.collection("products").find().toArray();

    console.log("Products:", products);
  }
}

export default ProductController;