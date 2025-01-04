import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import ComerciantePage from "./pages/ComerciantePage";
import EstablecimientoPage from "./pages/EstablecimientoPage";
import Navbar from "./components/Navbar";

const App: React.FC = () => {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="/comerciantes" element={<ComerciantePage />} />
        <Route path="/establecimientos" element={<EstablecimientoPage />} />
      </Routes>
    </Router>
  );
};

export default App;
