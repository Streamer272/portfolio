import { redirectMeTo } from "../RedirectMeTo/RedirectMeTo";
import "./Home.css";

export const Home = () => {
    return (
        <div className="home">
            <div className="introduction">
                <h3 className="animated-250ms">Hello,</h3><br />
                <h1 className="animated-1000ms">my name is Daniel Svitaň,</h1><br />
                <h2 className="animated-2000ms">and I'm a fullstack developer.</h2><br />
            </div>

            <div className="links">
                <p className="animated-3000ms">You can find all topics on the top of the page, go take a look at my <p className="link" onClick={() => redirectMeTo("/about")}>identity</p> first.</p><br />
                <p className="animated-4000ms">Tip: if you are annoyed by those animations, just press <kbd>Space</kbd>.</p>
            </div>
        </div>
    )
}
