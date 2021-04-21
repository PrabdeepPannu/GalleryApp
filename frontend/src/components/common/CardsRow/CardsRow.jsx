import React, { useState } from "react";
import "./CardsRow.css";

const CardsRow = ({ headding, children, name }) => {
  const [collapesed, setCollapesed] = useState(true);

  return (
    <div className="CardsRow ml-3 mr-3">
      <div className="CardsRow__Headding">{headding}</div>
      <div className={`CardsRow__Cards ${collapesed ? "no-wrap" : "wrap"}`}>
        {children}
      </div>
      <div className="CardsRow__footer">
        <button
          className="CardsRow__MoreBtn btn btn-outline-primary"
          onClick={() => setCollapesed(!collapesed)}
        >
          {collapesed ? `More ${name}` : `Less ${name}`}
        </button>
      </div>
    </div>
  );
};

export default CardsRow;
