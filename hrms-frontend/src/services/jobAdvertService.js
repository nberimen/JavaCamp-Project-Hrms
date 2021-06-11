import axios from 'axios'
export default class JobAdvertService {
    getAllJobAdvert = () => {
        return axios.get("http://localhost:8080/api/jobAdverts/getall");
    }

    addAdvert=advert=>{
        return axios.post("http://localhost:8080/api/jobAdverts/addAdvert",advert);
    }

    changeActive = id => {
        return axios.post(`http://localhost:8080/api/jobAdverts/changeActive/${id}`);
    
    }
}