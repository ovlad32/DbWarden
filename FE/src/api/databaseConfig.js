import api from "./api";

export default {
  getTypes() {
    return api.get("database/types").then(response => {
      //console.log(response.data);
      return response;
    });
    //.catch(err => console.log("could not load database type list: " + err));
  }
};
