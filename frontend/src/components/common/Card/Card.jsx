import React from 'react'
import './Card.css'

export default function Card({ children, minWidth = "200px", height = "100px", className }) {
  return (
    <div className={className ? `${className} Card` : "Card"} style={{ minWidth, height }}>
      {children}
    </div>
  )
}
