import api from "./api";

export default {
  getTypes() {
    return api
      .get("databases/types")
      .catch(e => console.error("Could not read datasource types:", e));
  }
};
