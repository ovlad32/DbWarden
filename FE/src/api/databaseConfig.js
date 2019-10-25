import api from "./api";

export default {
  getTypes() {
    return api
      .get("databases/types")
      .catch(e => console.error("Could not retrieve datasource types:", e));
  },
  get(filters) {
    return api({
      method: "GET",
      url: "databases",
      params: filters
    }).catch(e =>
      console.error("Could not retrieve database configurations", e)
    );
  }
};
