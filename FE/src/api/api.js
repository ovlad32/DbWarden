import axios from "axios";
import appConfig from "../app-config";
export default axios.create(appConfig.axios);
