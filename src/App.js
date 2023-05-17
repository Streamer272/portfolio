// TODO: make contact form
// TODO: add images
// TODO: make website interactive

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { useAnimate } from "./hooks/useAnimate";
import { Home } from "./components/Home/Home";
import { Navbar } from "./components/Navbar/Navbar";
import { About } from "./components/About/About";
import { Contact } from "./components/Contact/Contact";
import { Expertise } from "./components/Expertise/Expertise";
import { RedirectContainer } from "./components/RedirectMeTo/RedirectMeTo";
import { Projects } from "./components/Projects/Projects";
import { NotFound } from "./components/NotFound/NotFound";
import "./styles/App.css";
import "./styles/Global.css";
import "./styles/Classes.css";
import "./styles/TextAnimation.css";

export const App = () => {
    const animate = useAnimate();

    return (
        <Router>
            <Navbar />

            <div className={ `content ${animate ? "animate" : ""}` }>
                <Switch>
                    <Route path="/" component={ Home } exact />
                    <Route path="/about" component={ About } exact />
                    <Route path="/expertise" component={ Expertise } exact />
                    <Route path="/projects" component={ Projects } exact />
                    <Route path="/contact" component={ Contact } exact />
                    <Route component={ NotFound } />
                </Switch>
            </div>

            <RedirectContainer />
        </Router>
    )
}
