import axios from "axios"

const url= "http://localhost:8080";
export const getUser = ()=>axios.get(url)