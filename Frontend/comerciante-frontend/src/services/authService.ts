import axios from "axios";

const API_URL = "http://localhost:8080";

interface LoginData {
  email: string;
  password: string;
}

const login = async (data: LoginData) => {
  const response = await axios.post(`${API_URL}/auth/login`, data);
  return response.data;
};

export default { login };
