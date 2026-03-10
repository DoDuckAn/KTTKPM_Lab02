import ConnectDB from "../db/connectDB";

class UserController {
  static async getUsers() {
    const db = ConnectDB.getDB();

    const users = await db.collection("users").find().toArray();

    console.log("Users:", users);
  }
}

export default UserController;