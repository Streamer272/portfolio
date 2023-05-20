export const Home = () => {
  function onClick(url: string) {
    setTimeout(() => {
      window.location.assign(url);
    }, 500);
  }

  return (
    <button onClick={() => onClick("/story")} class="text-onPrimary">
      My story
    </button>
  );
};
