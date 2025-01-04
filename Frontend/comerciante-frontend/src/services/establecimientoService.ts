import axios from "axios";

const API_URL = "http://localhost:8080/establecimientos";

const getByComercianteId = async (comercianteId: number) => {
    const response = await axios.get(`${API_URL}/comerciante/${comercianteId}`, {
        headers: {
            Authorization: `Bearer ${localStorage.getItem("token")}`,
        },
    });
    return response.data;
};

export default { getByComercianteId };
