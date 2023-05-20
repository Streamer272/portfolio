<script lang="ts">
  import { redirectPos } from "../utils/redirect";
  let top: number;
  let left: number;

  redirectPos.subscribe((pos) => {
    if (!pos) return;

    top = pos[0];
    left = pos[1];
  });
</script>

{#if $redirectPos}
  <div
    class="redirect absolute w-8 h-8 rounded-full bg-primary"
    style="--top: {top}; --left: {left};"
  />
{/if}

<style lang="scss">
  .redirect {
    top: calc(var(--top) * 1px);
    left: calc(var(--left) * 1px);
    transform: translate(-50%, -50%);
    animation: expand 300ms ease-in-out forwards;
  }

  @keyframes expand {
    0% {
      width: 4rem;
      height: 4rem;
    }
    100% {
      width: 200vw;
      height: 200vw;
    }
  }
</style>
