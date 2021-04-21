import React from "react";
import { Searchbar } from "../../fieldTypes";
import "./Header.css";

class Header extends React.Component {
  render() {
    return (
      <div className="header">
        <div className="header-left">
          <img
            className="klipfolio-logo"
            src="images/logo.svg"
            alt="Klipfolio logo"
          ></img>
        </div>
        <div className="header-right">
          <Searchbar />
        </div>
      </div>
    );
  }
}

export default Header;
