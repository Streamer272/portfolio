import SlovakiaFlag from "../../images/slovak-flag.png";
import "./About.css";

export const About = () => {
    const birthDate = new Date("2006-08-23");
    const guitarStartDate = new Date("2016-01-01");
    const currentDate = new Date();

    return (
        <div className="about">
            <h1 className="title animated-250ms">About me</h1>

            <div className="personal-info">
                <div className="cell animated-1000ms">
                    Hi, my name is Daniel, and I am { currentDate.getFullYear() - birthDate.getFullYear() } years old web developer from Slovakia&nbsp;
                    <img src={ SlovakiaFlag } alt="Slovakia flag" title="Slovakia flag" className="flag" />
                </div>

                <div className="cell animated-4250ms">
                    I am currently studying at gymnasium <a href="https://skolasvr.edupage.org">Spojená Škola Svätej Rodiny</a> in Bratislava<br />
                    and <a href="https://itstep.us">IT Step Academy</a> (online classes).
                </div>

                <div className="cell animated-8000ms">
                    Do you know <a href="https://www.dofe.org">DofE</a>? I am nowadays running for bronze medal, already
                    completed sport, talent and tour, still finishing volunteering.
                </div>

                <div className="cell animated-13000ms">
                    But fear not, I am not just casual developer, I have life too. See some of my hobbies:
                    <br />
                    Badminton - I am member of <a href="https://badmintonland.sk">badminton team</a> in Slovakia.
                    <br />
                    Guitar - this is my { currentDate.getFullYear() - guitarStartDate.getFullYear() }th year at <a href="https://vymaps.com/SK/Sukromna-Zus-Macharova-T3884809">private music school Macharova</a>.
                </div>

                <div className="cell animated-20000ms">
                    My language skills: English, Slovak, basics of most slavic languages and a little German.
                </div>
            </div>
        </div>
    )
}
