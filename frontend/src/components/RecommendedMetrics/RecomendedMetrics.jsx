import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { CardsRow } from '../common/CardsRow/CardsRow'
import { CardMetrics } from '../fieldTypes'
import "./RecommendedMetrics.css"


export const RecommendedMetrics = () => {
  const [metrics, setMetrics] = useState([])
  useEffect(() => {
    const fetchData = async () => {
      const result = await axios("https://jsonplaceholder.typicode.com/posts")
      console.log(result.data);
      setMetrics(result.data)
    }
    fetchData()
  }, [])
  return (
    <CardsRow headding="Recommended Metrics">
      {metrics.map(metric => <CardMetrics key={metric.id} data={metric}></CardMetrics>)}
    </CardsRow>
  )
}
