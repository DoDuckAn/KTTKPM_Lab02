import ConnectDB from "../db/connectDB";

class OrderController {
  static async getOrders() {
    const db = ConnectDB.getDB();

    const orders = await db.collection("orders").find().toArray();

    console.log("Orders:", orders);
  }
}

export default OrderController;