import { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { redirectMeTo } from "../RedirectMeTo/RedirectMeTo";
import "./Navbar.css";

export const Navbar = () => {
    const [currentUrl, setCurrentUrl] = useState(window.location.pathname.toString());
    const history = useHistory();
    const routes = ["Home", "About", "Expertise", "Projects", "Contact"];

    useEffect(() => {
        history.listen((location) => {
            setCurrentUrl(location.pathname.toString());
        });
    }, [history, setCurrentUrl]);

    return (
        <div className="navbar">
            { routes.map((route, index) => {
                const current = currentUrl.includes(route.toLowerCase()) || (currentUrl === "/" && index === 0);

                return (
                    <h2 key={ index } onClick={() => redirectMeTo(index === 0 ? "" : route.toLowerCase())} className={ `${current ? "current" : ""}` }>
                        { route }
                    </h2>
                )
            }) }
        </div>
    )
}
