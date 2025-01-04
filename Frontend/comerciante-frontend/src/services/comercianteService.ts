import axios from "axios";

const API_URL = "http://localhost:8080/comerciantes";

const getAll = async () => {
    const response = await axios.get(API_URL, {
        headers: {
            Authorization: `Bearer ${localStorage.getItem("token")}`,
        },
    });
    return response.data;
};

export default { getAll };
