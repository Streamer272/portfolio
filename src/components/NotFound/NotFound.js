import { Link } from "react-router-dom";
import "./NotFound.css";

export const NotFound = () => {
    return (
        <div className="not-found">
            <h1>Hey buddy,</h1>
            <h2>You look lost.</h2>
            <Link to="/">Go home</Link>
        </div>
    )
}
