
import { api } from '../options.global';
import axios from 'axios';

class Model {
    constructor(table) {
        this.api = `${api}/${table}`;
    }
    
    async list() {
        const models = await axios.get(this.api);
        return models.data;
    }

    async loadById(id) {
        const model = await axios.get(`${this.api}/${id}`);
        return model.data;
    }   
    
    async add(data) {
        const model = await axios.post(`${this.api}`, data);
        return model.data;
    }

    async update(data) {
        const model = await axios.put(`${this.api}/${data.id}`, data);
        return model.data;
    }


}

export default Model;