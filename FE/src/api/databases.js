import api from "./api";

export default {
  getTypes() {
    return api.get("databases/types").catch(e => {
      throw new Error("Could not retrieve datasource types: " + e);
    });
  },
  getAll(filters) {
    return api({
      method: "GET",
      url: "databases/all",
      params: filters
    }).catch(e => {
      throw new Error("Could not retrieve database configurations: " + e);
    });
  },

  getIconFileName(dbType) {
    var iconfile = "";
    switch (dbType) {
      case "ORACLE":
        iconfile = "oracle.svg";
        break;
      case "SYBASE":
        iconfile = "sybase.svg";
        break;
      default:
        iconfile = "default.svg";
        break;
    }
    return require(`@/assets/db-icons/${iconfile}`);
  }
};
