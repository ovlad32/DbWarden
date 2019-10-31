import moment from "moment-timezone";
export const fmt = {
  methods: {
    fullDateTime(jsonTimestamp) {
      return moment.unix(jsonTimestamp).format("h:mm A, D MMM, YYYY");
    }
  }
};
