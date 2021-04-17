import React from "react";
import { Navbar } from "../../common";
import "./Header.css";

class Header extends React.Component {
  render() {
    return (
      <div className="container-fluid header">
        <div className="row justify-content-md-center">
          <section className="header-top">
            <section className="header-left col col-lg-2">
              <img className="klipfolio-logo" src="images/logo.svg" alt="Klipfolio logo"></img>
            </section>
            <section className="header-right col">
              <Navbar />
            </section>
          </section>
        </div>
      </div>
    );
  }
}

export default Header;
