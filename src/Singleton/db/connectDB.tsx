import { MongoClient, Db } from "mongodb";

class ConnectDB {
  private static client: MongoClient;
  private static db: Db;

  static async connect() {
    const url = "mongodb://localhost:27017";
    const dbName = "testdb";

    if (!ConnectDB.client) {
      ConnectDB.client = new MongoClient(url);
      await ConnectDB.client.connect();

      ConnectDB.db = ConnectDB.client.db(dbName);

      console.log("Connected to MongoDB");
    }

    return ConnectDB.db;
  }

  static getDB(): Db {
    if (!ConnectDB.db) {
      throw new Error("Database not connected. Call connect() first.");
    }
    return ConnectDB.db;
  }
}

export default ConnectDB;