import "./Projects.css";

export const Projects = () => {
    return (
        <div className="projects">
            <h1 className="title animated-250ms">My projects</h1>

            <ol>
                <li>
                    <h3 className="animated-750ms">Advent Challenge</h3>
                    <ul>
                        <li className="animated-1000ms">
                            Source code:

                            <ul>
                                <li className="animated-1250ms"><a href="https://github.com/7274-dev/AdventnaVyzva-React">Frontend</a></li>
                                <li className="animated-1500ms"><a href="https://github.com/7274-dev/AdventnaVyzva-GlobalBackend">Backend</a></li>
                            </ul>
                        </li>
                        <li className="animated-1750ms">Deployed on <a href="https://svr.sk">svr.sk</a></li>
                        <li className="animated-2000ms">
                            My contribution:

                            <ul>
                                <li className="animated-2250ms">- created frontend functionality</li>
                                <li className="animated-2500ms">- created base design</li>
                                <li className="animated-2750ms">- created public <a href="https://hub.docker.com/r/streamer272/adventnavyzva-react">docker image</a></li>
                                <li className="animated-3000ms">- helped fixing backend in production</li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ol>
        </div>
    )
}
