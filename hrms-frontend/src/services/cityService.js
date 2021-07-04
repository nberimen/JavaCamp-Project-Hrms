import axios from 'axios'

export default class CityService {
    getAllCities = () => {
        return axios.get("http://localhost:8080/api/cities/getall");
    }
}
