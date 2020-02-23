import axios from 'axios';
//TODO: Think how to do it correctly
import appConfig from '../../app-config';
export default axios.create(appConfig.axios);
