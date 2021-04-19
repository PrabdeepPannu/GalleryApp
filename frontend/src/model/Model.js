
import { api } from '../options.global';
import axios from 'axios';

class Model {
    constructor(table) {
        this.api = `${api}/${table}`;
    }
    
    async list() {
        const metrics = await axios.get(this.api);
        return metrics.data;
    }

    async loadById(id) {
        const metric = await axios.get(`${this.api}/${id}`);
        return metric.data;
    }   
    
    async add(data) {
        const metric = await axios.post(`${this.api}`, data);
        return metric.data;
    }

    async update(data) {
        const metric = await axios.put(`${this.api}/${data.id}`, data);
        return metric.data;
    }
    
    async listChild(parentId, childTable) {
        const children = await axios.get(`${this.api}/${parentId}/${childTable}`)
        return children.data;
    }

}

export default Model;