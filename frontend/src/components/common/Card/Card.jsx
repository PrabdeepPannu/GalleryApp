import React from 'react'
import './Card.css'

export default function Card({ children, maxWidth = "200px", minWidth = "200px", height = "100px", className }) {
  return (
    <div className={className ? `Card ${className} ` : "Card"} style={{ minWidth, height, maxWidth }}>
      {children}
      </div>
  )
}
