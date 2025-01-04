import React from "react";
import ComercianteTable from "../components/ComercianteTable";
import ReportButtons from "../components/ReportButtons";

const ComerciantePage: React.FC = () => {
    return (
        <div>
            <ComercianteTable />
            <ReportButtons />
        </div>
    );
};

export default ComerciantePage;
