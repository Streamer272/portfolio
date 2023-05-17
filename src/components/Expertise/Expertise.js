import "./Expertise.css";

export const Expertise = () => {
    return (
        <div className="expertise">
            <h1 className="title animated-250ms">My expertise</h1>

            <ol>
                <li>
                    <h3 className="animated-750ms">Frontend</h3>
                    <ul>
                        <li className="animated-1000ms">HTML + CSS</li>
                        <li className="animated-1250ms">JavaScript</li>
                        <li className="animated-1500ms">React</li>
                        <li className="animated-1750ms">SCSS</li>
                        <li className="animated-2000ms">Bootstrap, TailWindCSS</li>
                        <li className="animated-2250ms">Node.js</li>
                        <li className="animated-2500ms">Electron</li>
                    </ul>
                </li>

                <li>
                    <h3 className="animated-3000ms">Backend</h3>
                    <ul>
                        <li className="animated-3250ms">Golang</li>
                        <li className="animated-3500ms">Kotlin</li>
                        <li className="animated-3750ms">JavaScript</li>
                        <li className="animated-4000ms">Python</li>
                        <li className="animated-4250ms">SQL</li>
                    </ul>
                </li>

                <li>
                    <h3 className="animated-4750ms">Deployment</h3>
                    <ul>
                        <li className="animated-5000ms">Docker</li>
                        <li className="animated-5250ms">Apache</li>
                        <li className="animated-5500ms">Caddy</li>
                    </ul>
                </li>

                <li>
                    <h3 className="animated-6000ms">Version Control System</h3>
                    <ul>
                        <li className="animated-6250ms">Git</li>
                        <li className="animated-6500ms">Github</li>
                    </ul>
                </li>
            </ol>
        </div>
    )
}
