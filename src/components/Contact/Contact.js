import "./Contact.css";

export const Contact = () => {
    return (
        <div className="contact">
            <h1 className="title animated-250ms">Contact me</h1>

            <ul>
                {/* TODO: add modal */}
                <li className="animated-500ms"><a href="mailto:admin@streamer272.com">Gmail</a></li>
                <li className="animated-750ms"><a href="https://www.facebook.com/daniel.svitan.team7274">FaceBook</a></li>
                <li className="animated-1000ms"><a href="https://www.linkedin.com/in/daniel-svitan-2a86b1214/">LinkedIn</a></li>
            </ul>
        </div>
    )
}
