import React, { useState } from 'react'
import "./CardsRow.css"

export const CardsRow = ({ headding, children }) => {
  const [collapesed, setCollapesed] = useState(true)

  return (
    <div className="CardsRow">
      <div className="CardsRow__Headding">{headding}</div>
      <div className={`CardsRow__Cards ${collapesed ? "no-wrap" : "wrap"}`}>
        {children}
      </div>
      <div className="CardsRow__footer">
        <button className="CardsRow__MoreBtn" onClick={() => setCollapesed(!collapesed)}>{collapesed ? "More" : "Less"}</button>
      </div>
    </div>
  )
}
