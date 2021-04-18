// import { Header, Template, Cards } from './components/common';
// import { CardMetrics } from './components/fieldTypes';

import './App.css';
// function App() {
//   return (
//     <div className="App">
//       <div className="container-fluid">
//         <div className="row">
//         <Header />
//         </div>
//         <div className="row"></div>
//         <Template />
//         </div>
//     </div>
//   );
// }

import React from 'react'
import { RecommendedMetrics } from './components/RecommendedMetrics/RecomendedMetrics';
import { RecommendedServices } from './components/RecommendedServices/RecommendedServices';
import { ExistingModelledData } from './components/ExistingModelledData/ExistingModelledData';

export const App = () => {
  return (
    <>
      <RecommendedMetrics></RecommendedMetrics>
      <RecommendedServices></RecommendedServices>
      <ExistingModelledData></ExistingModelledData>
    </>
  )
}

export default App;
