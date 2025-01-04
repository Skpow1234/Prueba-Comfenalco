import React from "react";
import { Link } from "react-router-dom";

const Navbar: React.FC = () => {
    return (
        <nav>
            <ul>
                <li>
                    <Link to="/comerciantes">Comerciantes</Link>
                </li>
                <li>
                    <Link to="/establecimientos">Establecimientos</Link>
                </li>
                <li>
                    <Link to="/">Cerrar Sesión</Link>
                </li>
            </ul>
        </nav>
    );
};

export default Navbar;
