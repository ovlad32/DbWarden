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
      url: "databases",
      params: filters
    }).catch(e => {
      throw new Error("Could not retrieve database configurations: " + e);
    });
  },
  checkAvailability(id) {
    return api({
      method: "POST",
      url: "databases/check",
      data: { id }
    }).catch(e => {
      throw new Error("Could not check database availability: " + e);
    });
  },
  checkParams(item) {
    return api({
      method: "POST",
      url: "databases/test",
      data: item
    });
  },
  save(item) {
    return api({
      method: "POST",
      url: "databases",
      data: item
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
