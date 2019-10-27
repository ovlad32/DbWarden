import api from "./api";

export default {
  getTypes() {
    return api.get("databases/types").catch(e => {
      throw new Error("Could not retrieve datasource types:", e);
    });
  },
  getAll(filters) {
    return api({
      method: "GET",
      url: "databases/all",
      params: filters
    }).catch(e => {
      throw new Error("Could not retrieve database configurations", e);
    });
  }
};
