import React, { useState } from "react";
import "./CardsRow.css";

const CardsRow = ({ headding, children, name, onMoreClick, onLessClick }) => {
  const [collapesed, setCollapesed] = useState(true);

  const onMoreClickButton = async (e) => {
    setCollapesed(!collapesed);
    onMoreClick(e);
  };

  const onLessClickButton = async (e) => {
    setCollapesed(true);
    onLessClick(e);
  };
  return (
    <ul>
      <div className="CardsRow ml-3 mr-3">
        <div className="CardsRow__Headding">{headding}</div>
        <div
          className="CardsRow__Cards">
          {children}
        </div>
        <div className="CardsRow__footer">
          {collapesed ? (
            <button
              className="CardsRow__MoreBtn btn btn-outline-primary"
              onClick={onMoreClickButton}
            >
              {`More ${name}`}
            </button>
          ) : (
            <button
              className="CardsRow__MoreBtn btn btn-outline-primary"
              onClick={onLessClickButton}
            >
              {`Less ${name}`}
            </button>
          )}
        </div>
      </div>
    </ul>
  );
};

export default CardsRow;
